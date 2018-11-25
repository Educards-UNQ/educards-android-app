package educards.educards_service;

import java.util.List;

import educards.educards_model.Player;
import educards.educards_model.Ranking;
import educards.educards_model.RankingPlayer;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface EducardsService {

        @GET("/api/players")
         void getPlayer(@Query ("name") String username, @Query ("password") String password, Callback<Player> player);

        @POST("/api/players")
        void addPlayer(@Body Player player, Callback<Response> r);

        @GET("/api/rankings")
        void getRankings(Callback <List<Ranking>> callback);

        @POST("/api/rankings")
        void addRanking (@Body Ranking ranking);

}
