def call(repo,image_name,env)
withCredentials([credentialid: "docker_login_${env}", username: $username, password: $password])
{
    sh"""
        docker login ${repo} -u ${username} -p ${password}
        docker tag ${image_name} ${repo}/${image_name}
        docker push ${repo}/${image_name}    
     """
}