FROM ruby:2.5-alpine

ENV DIR=/work

COPY main.rb ${DIR}/main.rb

WORKDIR ${DIR}

EXPOSE 8080

CMD ruby main.rb
