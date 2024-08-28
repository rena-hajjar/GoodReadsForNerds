const apiUrl = 'https://localhost:8000/api/books';

export const getBooks = async () => {
  try {
    const response = await fetch(`${apiUrl}/books/get-books`);
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    throw error;
  }
};