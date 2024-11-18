import Header from "../components/Header";
import { useLocation } from "react-router-dom";
import useReviews from "../hooks/reviews";

export default function Review() {
  const location = useLocation();
  const { selectedPlate } = location.state || {};
  const { reviews } = useReviews()

  console.log(selectedPlate.id);
  console.log(reviews.map((review) => review.plate.id == selectedPlate.id))

  const filteredReviews = reviews.filter(
    (review) => review.plate.id === selectedPlate.id
  );
  
  return (
    <>
      <Header></Header>
      <h2>
       Reviews sobre <a style={{ color: "red" }}>{selectedPlate.name}</a>
      </h2>
      <div>
        {filteredReviews.length > 0 ? (
        <div>
          {filteredReviews.map((review) => (
          <ul>
            <li key={review.plate.id}>{review.user.name} - {review.comment} - {review.rating} estrelas</li>
          </ul>
          ))}
        </div>
        ) : (
          <p>Não há reviews sobre esse prato!</p>
        )}
      </div>
    </>
  );
}
