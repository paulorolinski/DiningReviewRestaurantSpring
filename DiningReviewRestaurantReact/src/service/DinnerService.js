import apiClient from "./ApiService";

export default {
    getDinners() {
        return apiClient.get("/dinners")
    },

    getDinnerById(id) {
        return apiClient.get(`dinners/${id}`)
    }
}