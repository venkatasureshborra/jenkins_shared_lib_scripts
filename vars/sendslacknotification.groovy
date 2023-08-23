def sendslacknotification(String buildStatus = 'STARTED'){

buildStatus = buildStatus ?: 'SUCCESS'
  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (${env.BUILD_URL})"

if (buildStatus == 'STARTED'){
colorName = 'YELLOW'
colorCode = '#FFFF00'
} else if (buildStatus == 'SUCCESS'){
colorName = 'GREEN'
colorCode = '#00FF00'
} else {
colorName = 'RED'
colorCode = '#FF0000'
}
slackSend ( color: colorCode, message: summary, channel: "#general" )
}

