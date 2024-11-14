import {Navigate, Route, Routes} from 'react-router-dom'
import Review from '../features/Review'
import Restaurant from '../features/Restaurant'
import Dinner from '../features/Dinner'

export default function AppRoutes() {
    return (
        <Routes>
            <Route path='/' element={<Restaurant />}></Route>
            <Route path='/reviews' element={<Review />}></Route>
            <Route path='/dinners' element={<Dinner />}></Route>
            <Route path="*" element={<Navigate to="/" replace />}></Route>
        </Routes>
    )
}
