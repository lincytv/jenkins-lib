def call(repo,image_name,env)
withCredentials(usernamePassword[(credentialsId: 'docker_login_dev', usernameVariable: $username, passwordVariable: $password]))
{
    sh"""
        docker login ${repo} -u ${username} -p ${password}
        docker tag ${image_name} ${repo}/${image_name}
        docker push ${repo}/${image_name}    
     """
}