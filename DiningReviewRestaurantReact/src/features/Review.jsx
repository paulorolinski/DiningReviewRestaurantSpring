import Header from "../components/Header";
import { useLocation } from "react-router-dom";
import useReviews from "../hooks/reviews";
import "../assets/review.css";
import { MdOutlineStar } from "react-icons/md";
import { IoPersonCircleSharp } from "react-icons/io5";
import { useNavigate } from "react-router-dom";
import Logout from "../components/Logout";

export default function Review() {
  const location = useLocation()
  const { selectedPlate, selectedRestaurant } = location.state || {}
  const { reviews } = useReviews()
  const navigate = useNavigate()

  // console.log(selectedPlate.id);
  // console.log(reviews.map((review) => review.plate.id == selectedPlate.id));
  // console.log(selectedRestaurant);

  const filteredReviews = reviews.filter(
    (review) => review.plate.id === selectedPlate.id
  );
  
  return (
    <>
      <header>
        <div onClick={() => navigate("/dinners", { state: { selectedRestaurant }})}>
          <Header></Header>
        </div>
        <h2 className="header">
          Avaliações sobre <a>{selectedPlate.name}</a> em{" "}
          <a>{selectedRestaurant.name}</a> - <a>{selectedRestaurant.cep}</a>
        </h2>
        <Logout />
      </header>
      <div style={{ margin: 100 }} className="flex-container">
        {filteredReviews.length > 0 ? (
          <div className="cards-review">
            {filteredReviews.map((review) => (
              <div className="card-review" key={review.id}>
                <div className="user">
                  <IoPersonCircleSharp className="icon-profile" size={50} />
                  <p style={{ paddingLeft: 10 }}>{review.user.username}</p>
                </div>
                <div className="content-review">
                  <div>
                    <div className="review-rating">
                      {" "}
                      {Array.from({ length: review.rating }, (_, index) => (
                        <MdOutlineStar key={index} className="icon-star" size={20}/>
                      ))}{" "}
                    </div>
                    <h4><a>Comentário:</a> {review.comment}</h4>
                  </div>
                </div>
              </div>
            ))}
          </div>
        ) : (
          <p>Não há reviews sobre esse prato!</p>
        )}
      </div>
    </>
  );
}
