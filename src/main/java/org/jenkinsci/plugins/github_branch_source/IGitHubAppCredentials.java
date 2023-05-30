package org.jenkinsci.plugins.github_branch_source;

import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import hudson.util.Secret;
import org.kohsuke.github.authorization.AuthorizationProvider;

public interface IGitHubAppCredentials extends StandardUsernamePasswordCredentials {

  String getAppID();

  String getOwner();

  Secret getPrivateKey();

  void setOwner(String owner);

  AuthorizationProvider getAuthorizationProvider();
}
