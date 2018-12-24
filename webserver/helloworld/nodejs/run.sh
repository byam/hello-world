
#!/usr/bin/env bash

# ==============================================
# Shell settings
# ----------------------------------------------

# Deny undefined vars
set -o nounset
# Immediately exit on error
set -o errexit

# ==============================================
# Build & Run
# ----------------------------------------------

CONTAINER_IMAGE=nodejs-xmas

docker build --tag ${CONTAINER_IMAGE}:latest .

docker run --rm -p 8080:8080 ${CONTAINER_IMAGE}:latest
