#!/bin/bash

set -o errexit

SC_CONTRACT_DOCKER_VERSION="${SC_CONTRACT_DOCKER_VERSION:-2.2.0.BUILD-SNAPSHOT}"
APP_IP="$( ./whats_my_ip.sh )"
APP_PORT="${APP_PORT:-9876}"
ARTIFACTORY_PORT="${ARTIFACTORY_PORT:-8081}"
APPLICATION_BASE_URL="http://${APP_IP}:${APP_PORT}"
ARTIFACTORY_URL="http://${APP_IP}:${ARTIFACTORY_PORT}/artifactory/gradle-release/"
CURRENT_DIR="$( pwd )"
PROJECT_NAME="${PROJECT_NAME:-cloudcontract-producer}"
PROJECT_GROUP="${PROJECT_GROUP:-com.datson}"
PROJECT_VERSION="${PROJECT_VERSION:-2.0.0-SNAPSHOT}"

echo "Sc Contract Version [${SC_CONTRACT_DOCKER_VERSION}]"
echo "Application URL [${APPLICATION_BASE_URL}]"
echo "Artifactory URL [${ARTIFACTORY_URL}]"
echo "Project Version [${PROJECT_VERSION}]"
echo "Whats my IP? [${APP_IP}]"

mkdir -p build/spring-cloud-contract/output

sudo docker run --rm \
-e "APPLICATION_BASE_URL=${APPLICATION_BASE_URL}" \
-e "PUBLISH_ARTIFACTS=true" \
-e "PROJECT_NAME=${PROJECT_NAME}" \
-e "PROJECT_GROUP=${PROJECT_GROUP}" \
-e "REPO_WITH_BINARIES_URL=${ARTIFACTORY_URL}" \
-e "PROJECT_VERSION=${PROJECT_VERSION}" \
-v "${CURRENT_DIR}/contracts/:/contracts:ro" \
-v "${CURRENT_DIR}/build/spring-cloud-contract/output:/spring-cloud-contract-output/" \
springcloud/spring-cloud-contract:"${SC_CONTRACT_DOCKER_VERSION}"

sudo docker run --rm \
-v "${CURRENT_DIR}/build/spring-cloud-contract/output:/spring-cloud-contract-output/" \
springcloud/spring-cloud-contract:"${SC_CONTRACT_DOCKER_VERSION}" \
chown -R $(id -u):$(id -g) "/spring-cloud-contract-output/"