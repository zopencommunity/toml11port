node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/toml11port.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/toml11port.git'), string(name: 'PORT_DESCRIPTION', value: 'toml11 is a feature-rich TOML language library for C++11/14/17/20.' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
