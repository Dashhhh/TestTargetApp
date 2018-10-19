package com.dashhh.ej2.testtargetapp.Async;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AsyncGetUserInfo extends AsyncTask<Void, Integer, JSONObject> {

    private String userId;


    public AsyncGetUserInfo(String userId) {
        this.userId = userId;
    }

    public AsyncGetUserInfo() {
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
                    .url("https://api.github.com/users/Dashhhh")
                    .post(formBody)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            Response response = client.newCall(request).execute();

                /*

                !!!! Parsing !!!!


                    {
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
                      "site_admin": false,
                      "name": "devil1032",
                      "company": null,
                      "blog": "",
                      "location": null,
                      "email": null,
                      "hireable": null,
                      "bio": null,
                      "public_repos": 21,
                      "public_gists": 0,
                      "followers": 1,
                      "following": 1,
                      "created_at": "2017-02-12T10:37:11Z",
                      "updated_at": "2018-10-19T09:12:19Z"
                    }

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
