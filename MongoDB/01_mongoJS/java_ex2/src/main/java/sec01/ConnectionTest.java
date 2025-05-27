package sec01;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionTest {
    public static void main(String[] args) {
        String uri = "mongodb://127.0.0.1:27017";
        String db = "todo_db";

        // try( ) 소괄호 안에 객체 생성 코드 넣으면 close() 안 해줘도 됨
        // 마치 RDB 할 때 driveManager 역할
        try (MongoClient client = MongoClients.create(uri)){
            MongoDatabase database = client.getDatabase(db);
            // logback 사용하면
            // 출력 따로 코드 안 해도 실행 시 log 정보 출력해줌.
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
