package com.example.bananaking.http.api;

import com.example.bananaking.mananger.dto.FbResponse;
import com.example.bananaking.mananger.dto.fanspage.CommentDTO;
import com.example.bananaking.mananger.dto.fanspage.PageDTO;
import com.example.bananaking.mananger.dto.fanspage.PostDTO;
import com.example.bananaking.mananger.dto.fanspage.ReactionDTO;
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
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/page"> docs </a>
     *
     * @param pageId
     * @param fields
     * @param after
     * @param before
     * @return
     */
    @GET("{pageId}")
    Call<PageDTO> page(@Path("pageId") String pageId,
                       @Query("fields") String fields,
                       @Query("after") String after,
                       @Query("before") String before);

    /**
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/page/feed"> docs </a>
     *
     * @param pageId
     * @param fields
     * @param published
     * @param limit
     * @param after
     * @param before
     * @return
     */
    @GET("{pageId}/posts")
    Call<FbResponse<PostDTO>> posts(@Path("pageId") String pageId,
                                    @Query("fields") String fields,
                                    @Query("is_published") boolean published,
                                    @Query("limit") int limit,
                                    @Query("after") String after,
                                    @Query("before") String before);

    /**
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/v3.0/comment"> docs </a>
     *
     * @param postId
     * @param fields
     * @param limit
     * @param after
     * @param before
     * @return
     */
    @GET("{postId}/comments")
    Call<FbResponse<CommentDTO>> postComments(@Path("postId") String postId,
                                              @Query("fields") String fields,
                                              @Query("limit") int limit,
                                              @Query("after") String after,
                                              @Query("before") String before);

    /**
     *
     * @param postId
     * @param fields
     * @param limit
     * @param after
     * @param before
     * @return
     */
    @GET("{postId}/reactions")
    Call<FbResponse<ReactionDTO>> postReactions(@Path("postId") String postId,
                                                @Query("fields") String fields,
                                                @Query("limit") int limit,
                                                @Query("after") String after,
                                                @Query("before") String before);
}
