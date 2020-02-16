# Provide the Spring Cloud Contract Docker version
SC_CONTRACT_DOCKER_VERSION="${SC_CONTRACT_DOCKER_VERSION:-2.2.0.BUILD-SNAPSHOT}"
# The IP at which the app is running and Docker container can reach it
APP_IP="$( ./whats_my_ip.sh )"
# Spring Cloud Contract Stub Runner properties
STUBRUNNER_PORT="8083"
# Stub coordinates 'groupId:artifactId:version:classifier:port'
STUBRUNNER_IDS="com.datson:cloudcontract-producer:2.0.0-SNAPSHOT:stubs:9876"
STUBRUNNER_REPOSITORY_ROOT="http://${APP_IP}:8081/artifactory/gradle-dev-local/"
USER="${USER:-admin}"
PASSWORD="${PASSWORD:-admin123}"

# Run the docker with Stub Runner Boot
sudo docker run  --rm \
-e "STUBRUNNER_IDS=${STUBRUNNER_IDS}" \
-e "STUBRUNNER_REPOSITORY_ROOT=${STUBRUNNER_REPOSITORY_ROOT}" \
-e "STUBRUNNER_STUBS_MODE=REMOTE" \
-e "REPO_WITH_BINARIES_USERNAME=${USER}" \
-e "REPO_WITH_BINARIES_PASSWORD=${PASSWORD}" \
-p "${STUBRUNNER_PORT}:${STUBRUNNER_PORT}" \
-p "9876:9876" springcloud/spring-cloud-contract-stub-runner:"${SC_CONTRACT_DOCKER_VERSION}"