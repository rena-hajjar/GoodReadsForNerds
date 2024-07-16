import './App.css';

function App() {
  return (
    <div className="App">
      <div className="create-book">
        <form>
          <label>
            Book Author
            <input title='Book Author: '/>
          </label>
          <span></span>
          <label>
            Book Title
            <input title='Book Title: '/>
          </label>
          <button>Add book to list</button>
        </form>
      </div>
    </div>
  );
}

export default App;
