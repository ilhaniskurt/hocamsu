# Hocamsu - Spring Boot Web Backend

## Authors

- Ilhan Yavuz Iskurt
- Janset Tunca
- Ufuk Guvenc

## Introduction

Hocamsu is a Spring Boot web backend designed to facilitate an anonymous platform where users can view, rate, and comment on instructors. The system provides an intuitive set of RESTful APIs to interact with instructor and comment entities.

## Data Models

### Instructor

- `id`: Long (Primary Key, Auto-Generated)
- `name`: String (Non-Nullable)
- `rating`: Long
- `courses`: String (Non-Nullable)
- `comments`: List<Comment> (One-to-Many Relationship)

### Comment

- `id`: Long (Primary Key, Auto-Generated)
- `text`: String (Non-Nullable)
- `instructor`: Instructor (Many-to-One Relationship)

## API Endpoints

### Instructor Controller

#### Get All Instructors

- `GET /instructors`
- Returns a list of all instructors.
- Response: JSON Array:
  ```json
  [
    {
      "id": 1,
      "name": "John Doe",
      "rating": 3,
      "courses": "CS210,CS310"
    },
    {
      "id": 2,
      "name": "Jane Doe",
      "rating": 0,
      "courses": "CS305"
    }
  ]
  ```

#### Search Instructors by Name

- `GET /instructors/search?name={name}`
- Search for instructors by name.
- Parameters:
  - `name`: String (required)
- Response: JSON Array:
  ```json
  [
    {
      "id": 2,
      "name": "Jane Doe",
      "rating": 0,
      "courses": "CS305"
    }
  ]
  ```

#### Get Instructor by ID

- `GET /instructors/{id}`
- Fetches a specific instructor by ID.
- Path Variables:
  - `id`: Long
- Response: JSON Object:
  ```json
  {
    "id": 2,
    "name": "Jane Doe",
    "rating": 0,
    "courses": "CS305"
  }
  ```

#### Like an Instructor

- `PUT /instructors/{id}/like`
- Increment the rating count of an instructor.
- Path Variables:
  - `id`: Long
- Response: JSON Object:
  ```json
  {
    "id": 2,
    "name": "Jane Doe",
    "rating": 1,
    "courses": "CS305"
  }
  ```

#### Dislike an Instructor

- `PUT /instructors/{id}/dislike`
- Decrement the rating count of an instructor.
- Path Variables:
  - `id`: Long
- Response: JSON Object:
  ```json
  {
    "id": 2,
    "name": "Jane Doe",
    "rating": -1,
    "courses": "CS305"
  }
  ```

#### Create an Instructor

- `POST /instructors`
- Creates a new instructor.
- Accepts: application/json
- Request Body:
  ```json
  {
    "name": "Jane Doe",
    "courses": "CS305"
  }
  ```
- Response: JSON Object:
  ```json
  {
    "id": 2,
    "name": "Jane Doe",
    "rating": 0,
    "courses": "CS305"
  }
  ```

### Comment Controller

#### Create a Comment

- `POST /comments/{instructorId}`
- Adds a comment to an instructor.
- Path Variables:
  - `instructorId`: Long
- Accepts: application/json
- Request Body:
  ```json
  {
    "text": "John is great"
  }
  ```
- Response: JSON Object:
  ```json
  {
    "id": 1,
    "name": "John is great"
  }
  ```

#### Get Comments by Instructor ID

- `GET /comments/{instructorId}`
- Retrieves all comments associated with a specific instructor.
- Path Variables:
  - `instructorId`: Long
- Response: JSON Array:
  ```json
  [
    {
      "id": 1,
      "text": "John is great"
    },
    {
      "id": 2,
      "text": "John sucks"
    }
  ]
  ```
