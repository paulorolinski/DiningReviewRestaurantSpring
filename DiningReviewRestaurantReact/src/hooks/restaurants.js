import { useQuery } from "@tanstack/react-query"
import RestaurantService from "../service/RestaurantService";

export default function useRestaurant() {
    const { data: restaurants = [], isLoading, isError} = useQuery({
        queryKey: ["restaurants"],
        queryFn: async () => {
            const { data } = await RestaurantService.getRestaurants()
            return data ?? [];
        }
    })

    return {restaurants, isLoading, isError}
}