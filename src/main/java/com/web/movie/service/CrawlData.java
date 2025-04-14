package com.web.movie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.movie.model.Movie;
import com.web.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CrawlData {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public void crawlMovies() throws Exception {
        int page = 1;
        HttpClient client = HttpClient.newHttpClient();
        String baseUrl = "https://phimapi.com/danh-sach/phim-moi-cap-nhat?page=";

        while (true) {
            System.out.println("Fetching page " + page + "...");

            // Tạo URL và loại bỏ khoảng trắng/ký tự không hợp lệ
            String url = baseUrl + page;
            try {
                // Xác nhận URL hợp lệ
                URI uri = URI.create(url.trim()); // Loại bỏ khoảng trắng đầu/cuối

                // Gọi API
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(uri)
                        // .header("Authorization", "Bearer your_api_key") // Nếu cần
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() != 200) {
                    System.out.println("HTTP Error: " + response.statusCode());
                    break;
                }

                // Parse JSON
                Map<String, Object> data = objectMapper.readValue(response.body(), Map.class);
                if (!(boolean) data.get("status")) {
                    System.out.println("API status false");
                    break;
                }

                List<Map<String, Object>> items = (List<Map<String, Object>>) data.get("items");
                if (items.isEmpty()) {
                    System.out.println("No more data.");
                    break;
                }

                // Lưu dữ liệu vào database
                for (Map<String, Object> item : items) {
                    Map<String, String> modified = (Map<String, String>) item.get("modified");

                    Movie movie = Movie.builder()
                            .name((String) item.get("name"))
                            .originName((String) item.get("origin_name"))
                            .description("A great movie")
                            .posterUrl((String) item.get("poster_url"))
                            .thumbUrl((String) item.get("thumb_url"))
                            .year((Integer) item.get("year"))
                            .duration("2h30m")
                            .country("Viet Nam")
                            .language("Vietnamese")
                            .build();

                    movieRepository.save(movie);
                }

                System.out.println("Page " + page + " saved (" + items.size() + " items).");

                // Kiểm tra phân trang
                Map<String, Object> pagination = (Map<String, Object>) data.get("pagination");
                int totalPages = (Integer) pagination.get("totalPages");
                if (page >= totalPages) {
                    System.out.println("Reached last page.");
                    break;
                }

                page++;
                Thread.sleep(1000); // Chờ 1 giây tránh rate limit
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid URL format: " + url + " - Error: " + e.getMessage());
                break;
            }
        }

        System.out.println("Crawling completed.");
    }
}