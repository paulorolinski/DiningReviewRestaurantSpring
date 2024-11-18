import apiClient from "./ApiService";

export default {
    getRestaurants() {
        return apiClient.get("/restaurants")
    },

    getRestaurantById(id) {
        return apiClient.get(`restaurants/${id}`)
    }
}