package com.dashhh.ej2.testtargetapp.Async;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AsyncGetUserInfo_Repos extends AsyncTask<Void, Integer, JSONObject> {

    private String userId;


    public AsyncGetUserInfo_Repos(String userId) {
        this.userId = userId;
    }

    public AsyncGetUserInfo_Repos() {
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        JSONObject jsonObject = new JSONObject();
        String result = null;
        try {

            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add("id", userId)  // 유저아이디 " ~/user/{userId} "
                    .build();
            Request request = new Request.Builder()
                    .url("https://api.github.com/users/Dashhhh/repos")
                    .post(formBody)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            Response response = client.newCall(request).execute();

                /*

                !!!! Parsing !!!!


                                    {
                       "id": 147330553,
                       "node_id": "MDEwOlJlcG9zaXRvcnkxNDczMzA1NTM=",
                       "name": "AMTalk",
                       "full_name": "Dashhhh/AMTalk",
                       "private": false,
                       "owner": {
                         "login": "Dashhhh",
                         "id": 25720120,
                         "node_id": "MDQ6VXNlcjI1NzIwMTIw",
                         "avatar_url": "https://avatars1.githubusercontent.com/u/25720120?v=4",
                         "gravatar_id": "",
                         "url": "https://api.github.com/users/Dashhhh",
                         "html_url": "https://github.com/Dashhhh",
                         "followers_url": "https://api.github.com/users/Dashhhh/followers",
                         "following_url": "https://api.github.com/users/Dashhhh/following{/other_user}",
                         "gists_url": "https://api.github.com/users/Dashhhh/gists{/gist_id}",
                         "starred_url": "https://api.github.com/users/Dashhhh/starred{/owner}{/repo}",
                         "subscriptions_url": "https://api.github.com/users/Dashhhh/subscriptions",
                         "organizations_url": "https://api.github.com/users/Dashhhh/orgs",
                         "repos_url": "https://api.github.com/users/Dashhhh/repos",
                         "events_url": "https://api.github.com/users/Dashhhh/events{/privacy}",
                         "received_events_url": "https://api.github.com/users/Dashhhh/received_events",
                         "type": "User",
                         "site_admin": false
                       },
                       "html_url": "https://github.com/Dashhhh/AMTalk",
                       "description": "First Share (2017.11.29)",
                       "fork": true,
                       "url": "https://api.github.com/repos/Dashhhh/AMTalk",
                       "forks_url": "https://api.github.com/repos/Dashhhh/AMTalk/forks",
                       "keys_url": "https://api.github.com/repos/Dashhhh/AMTalk/keys{/key_id}",
                       "collaborators_url": "https://api.github.com/repos/Dashhhh/AMTalk/collaborators{/collaborator}",
                       "teams_url": "https://api.github.com/repos/Dashhhh/AMTalk/teams",
                       "hooks_url": "https://api.github.com/repos/Dashhhh/AMTalk/hooks",
                       "issue_events_url": "https://api.github.com/repos/Dashhhh/AMTalk/issues/events{/number}",
                       "events_url": "https://api.github.com/repos/Dashhhh/AMTalk/events",
                       "assignees_url": "https://api.github.com/repos/Dashhhh/AMTalk/assignees{/user}",
                       "branches_url": "https://api.github.com/repos/Dashhhh/AMTalk/branches{/branch}",
                       "tags_url": "https://api.github.com/repos/Dashhhh/AMTalk/tags",
                       "blobs_url": "https://api.github.com/repos/Dashhhh/AMTalk/git/blobs{/sha}",
                       "git_tags_url": "https://api.github.com/repos/Dashhhh/AMTalk/git/tags{/sha}",
                       "git_refs_url": "https://api.github.com/repos/Dashhhh/AMTalk/git/refs{/sha}",
                       "trees_url": "https://api.github.com/repos/Dashhhh/AMTalk/git/trees{/sha}",
                       "statuses_url": "https://api.github.com/repos/Dashhhh/AMTalk/statuses/{sha}",
                       "languages_url": "https://api.github.com/repos/Dashhhh/AMTalk/languages",
                       "stargazers_url": "https://api.github.com/repos/Dashhhh/AMTalk/stargazers",
                       "contributors_url": "https://api.github.com/repos/Dashhhh/AMTalk/contributors",
                       "subscribers_url": "https://api.github.com/repos/Dashhhh/AMTalk/subscribers",
                       "subscription_url": "https://api.github.com/repos/Dashhhh/AMTalk/subscription",
                       "commits_url": "https://api.github.com/repos/Dashhhh/AMTalk/commits{/sha}",
                       "git_commits_url": "https://api.github.com/repos/Dashhhh/AMTalk/git/commits{/sha}",
                       "comments_url": "https://api.github.com/repos/Dashhhh/AMTalk/comments{/number}",
                       "issue_comment_url": "https://api.github.com/repos/Dashhhh/AMTalk/issues/comments{/number}",
                       "contents_url": "https://api.github.com/repos/Dashhhh/AMTalk/contents/{+path}",
                       "compare_url": "https://api.github.com/repos/Dashhhh/AMTalk/compare/{base}...{head}",
                       "merges_url": "https://api.github.com/repos/Dashhhh/AMTalk/merges",
                       "archive_url": "https://api.github.com/repos/Dashhhh/AMTalk/{archive_format}{/ref}",
                       "downloads_url": "https://api.github.com/repos/Dashhhh/AMTalk/downloads",
                       "issues_url": "https://api.github.com/repos/Dashhhh/AMTalk/issues{/number}",
                       "pulls_url": "https://api.github.com/repos/Dashhhh/AMTalk/pulls{/number}",
                       "milestones_url": "https://api.github.com/repos/Dashhhh/AMTalk/milestones{/number}",
                       "notifications_url": "https://api.github.com/repos/Dashhhh/AMTalk/notifications{?since,all,participating}",
                       "labels_url": "https://api.github.com/repos/Dashhhh/AMTalk/labels{/name}",
                       "releases_url": "https://api.github.com/repos/Dashhhh/AMTalk/releases{/id}",
                       "deployments_url": "https://api.github.com/repos/Dashhhh/AMTalk/deployments",
                       "created_at": "2018-09-04T10:43:24Z",
                       "updated_at": "2018-09-04T10:43:26Z",
                       "pushed_at": "2018-04-09T02:20:17Z",
                       "git_url": "git://github.com/Dashhhh/AMTalk.git",
                       "ssh_url": "git@github.com:Dashhhh/AMTalk.git",
                       "clone_url": "https://github.com/Dashhhh/AMTalk.git",
                       "svn_url": "https://github.com/Dashhhh/AMTalk",
                       "homepage": null,
                       "size": 1497,
                       "stargazers_count": 0,
                       "watchers_count": 0,
                       "language": "Java",
                       "has_issues": false,
                       "has_projects": true,
                       "has_downloads": true,
                       "has_wiki": true,
                       "has_pages": false,
                       "forks_count": 0,
                       "mirror_url": null,
                       "archived": false,
                       "open_issues_count": 0,
                       "license": null,
                       "forks": 0,
                       "open_issues": 0,
                       "watchers": 0,
                       "default_branch": "master"
                     },

                */
            result = response.body().string();
            JSONObject castJSON = new JSONObject(result);
            jsonObject = castJSON;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;

    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);

    }

}
