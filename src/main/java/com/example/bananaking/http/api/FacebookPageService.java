package com.example.bananaking.http.api;

import com.example.bananaking.mananger.dto.FbResponse;
import com.example.bananaking.mananger.dto.fanspage.PageDTO;
import com.example.bananaking.mananger.dto.fanspage.Post;
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
     * @param pageId
     * @param fields
     * @param after
     * @param before
     * @return
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/page"> docs </a>
     */
    @GET("{pageId}")
    Call<PageDTO> page(@Path("pageId") String pageId,
                       @Query("fields") String fields,
                       @Query("after") String after,
                       @Query("before") String before);

    /**
     * @param pageId
     * @param fields
     * @param after
     * @param before
     * @return
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/page/feed"> docs </a>
     */
    @GET("{pageId}/posts")
    Call<FbResponse<Post>> posts(@Path("pageId") String pageId,
                                 @Query("fields") String fields,
                                 @Query("after") String after,
                                 @Query("before") String before);
}
