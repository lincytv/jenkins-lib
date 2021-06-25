def call(repo,image_name,env)
withCredentials([usernamePassword(credentialsId: 'docker_login_dev', Username: 'Username', Password: 'Password')])
{
    sh"""
        echo "docker push";
        docker login ${repo} -u ${Username} -p ${Password};
        docker tag ${image_name} ${repo}/${image_name};
        docker push ${repo}/${image_name};
     """
}