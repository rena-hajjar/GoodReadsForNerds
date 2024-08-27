import { useState, useEffect } from "react";
import axios from "axios";

const BookList = () => {
    const [books, setBooks] = useState([]);
    const [errorMessage, setErrorMessage] = useState('');

    useEffect(() => {
        axios({
            method: 'get',
            url: 'http://localhost:8000/api/books/get-books',
            withCredentials: false,
        }).then((response) => {
            setBooks(response.data);
        })
        .catch((error) => {
            console.log({ Error: error });
            setErrorMessage("Something went wrong");
        })
    })

    return (
        <div>
        {errorMessage && <div>{errorMessage}</div>}
        <ul>
            {books.map((book) => (
            <li key={book.id}>
                <h2>{book.title}</h2>
                <p>{book.author}</p>
            </li>
            ))}
        </ul>
        </div>
    );
};

export default BookList;