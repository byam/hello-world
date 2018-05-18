# Docker Logs with Fluentd and ElasticSearch

## Resource
- [How To Centralize Your Docker Logs with Fluentd and ElasticSearch on Ubuntu 16.04](https://www.digitalocean.com/community/tutorials/how-to-centralize-your-docker-logs-with-fluentd-and-elasticsearch-on-ubuntu-16-04)

## Implement

### 1. Installing Fluentd

1. Create VM on GCP
```bash
# create
gcloud compute --project "cet-dev" instances create "try-byam" --zone "asia-east1-b" --machine-type "n1-standard-1" --image="ubuntu-1604-xenial-v20180509" --image-project="ubuntu-os-cloud"

# connect
gcloud compute --project "cet-dev" ssh "try-byam" --zone asia-east1-b
```

2. Install Fluentd
```bash
# download the script
curl -L http://toolbelt.treasuredata.com/sh/install-ubuntu-xenial-td-agent2.sh -o install-td-agent.sh

# install td-agent
sh install-td-agent.sh

# start
sudo systemctl start td-agent
```

3. Install ruby
```bash
sudo apt-get install ruby-full
```

4. Install Elasticsearch plugin for Fluentd
```bash
sudo apt-get install build-essential
sudo td-agent-gem install fluent-plugin-elasticsearch
```

5. Install docker
```bash
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
sudo apt-get update
sudo apt-get install -y docker-ce
sudo systemctl status docker
```

### 2. Configuring Fluentd

1. Configure fluentd file

`/etc/td-agent/td-agent.conf`:
```bash 
<source>
  @type forward
  port  24224
</source>

<match docker.**>
  @type elasticsearch
  logstash_format true
  host 127.0.0.1
  port 9200
  flush_interval 5s
</match>
```

2. Restart settings
```bash
sudo systemctl restart td-agent
```

### 3. Starting the Elasticsearch Container

1. Increase the value of `max_map_count` of Docker host
```bash
sudo sysctl -w vm.max_map_count=262144
```

2. Install and Run Elasticsearch container
```bash
sudo docker run -d -p 9200:9200 -p 9300:9300 elasticsearch
```


### 4. Generating Logs from a Docker Container

1.  Docker to flush the logs using the native Fluentd logging driver
```bash
sudo docker run --log-driver=fluentd ubuntu /bin/echo 'Hello world'
```

2. Confirm that Elasticsearch is receiving the events.
```bash
curl -XGET 'http://localhost:9200/_all/_search?q=*'
```
