import { useQuery } from "@tanstack/react-query"
import DinnerService from "../service/DinnerService";

export default function useDinner() {
    const { data: dinners = []} = useQuery({
        queryKey: ["dinners"],
        queryFn: async () => {
            const { data } = await DinnerService.getDinners()
            return data ?? [];
        }
    })

    return {dinners}
}