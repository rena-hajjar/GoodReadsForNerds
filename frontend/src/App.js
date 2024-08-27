import './App.css';
import axios from 'axios';
import BookList from './BookList';

function App() {
  const onSubmit = async (e) => {

    const form = e.target
    const formData = new FormData(form)

    const apiUrl = 'https://localhost:8000/api/books';

    try {
      await axios.post(`${apiUrl}/new-book`, { formData });
      alert('Data created successfully');
    } catch (error) {
      console.log("Error creating data: ", error);
    }

    // fetch(`${apiUrl}/new-book/title=${e.target[0].value}&author=${e.target[1].value}`, { method: form.method, body: formData })

    console.log(formData);
  }

  return (
    <div className="App">
      <div className="create-book">
        <form method='post' onSubmit={onSubmit}>
          <label>
            Book Author
            <input title='Book Author: ' placeholder='Enter author name' name='title'/>
          </label>
          <span></span>
          <label>
            Book Title
            <input title='Book Title: ' placeholder='Enter book title' name="author"/>
          </label>
          <button type="submit">Add book to list</button>
        </form>
        <div>{<BookList></BookList>}</div>
      </div>
    </div>
  );
}

export default App;
