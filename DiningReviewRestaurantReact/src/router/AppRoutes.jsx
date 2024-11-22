import {Navigate, Route, Routes} from 'react-router-dom'
import Review from '../features/Review'
import Restaurant from '../features/Restaurant'
import Dinner from '../features/Dinner'
import Login from '../features/Login'
import Register from '../features/Register'
import Home from '../features/Home'

export default function AppRoutes() {
    return (
        <Routes>
            <Route path='/restaurants' element={<Restaurant />}></Route>
            <Route path='/reviews' element={<Review />}></Route>
            <Route path='/dinners' element={<Dinner />}></Route>
            <Route path='/login' element={<Login />}></Route>
            <Route path='/register' element={<Register />}></Route>
            <Route path='/' element={<Home />}></Route>
            <Route path="*" element={<Navigate to="/" replace />}></Route>
        </Routes>
    )
}
