import apiClient from "./ApiService";

export default {
    getReviews() {
        return apiClient.get("/reviews")
    },
    getReviewsById(id) {
        return apiClient.get(`/reviews/${id}`)
    }
}