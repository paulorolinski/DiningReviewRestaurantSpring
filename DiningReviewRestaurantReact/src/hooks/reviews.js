import { useQuery } from "@tanstack/react-query"
import ReviewService from "../service/ReviewService"

export default function useReviews() {
    const { data: reviews = []} = useQuery({
        queryKey: ["reviews"],
        queryFn: async () => {
            const { data } = await ReviewService.getReviews()
            return data ?? [];
        }
    })

    return {reviews}
}