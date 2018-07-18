package com.example.bananaking.http.api;

import com.fasterxml.jackson.databind.JsonNode;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jerry on 2018/7/19.
 *
 * @author jerry
 */
public interface FacebookPageService {

    /**
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/page/"> docs </a>
     * @param pageId
     * @return
     */
    @GET("{pageId}/")
    Call<JsonNode> posts(
        @Path("pageId") String pageId,
        @Query("fields") String fields,
        @Query("after") String after,
        @Query("before") String before);
}
