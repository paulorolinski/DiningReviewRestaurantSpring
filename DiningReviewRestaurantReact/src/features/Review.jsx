import useReviews from "../hooks/reviews";
export default function Review() {
  const { reviews } = useReviews();
  return (
    <>
      <header>
        <a href="/dinners">
          <img
            src="https://cdn-icons-png.flaticon.com/512/5774/5774594.png"
            alt="voltar"
            style={{ width: 50, height: 50 }}
          />
        </a>
        <h1>Reviews</h1>
      </header>
      <ul>
        {reviews.map((review) => (
          <li className="itemLista" key={review.id}>
            {review.user.name}: {review.comment}
          </li>
        ))}
      </ul>
    </>
  );
}
