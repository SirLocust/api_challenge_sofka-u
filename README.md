# Welcome to Solution Case Challenge

#notes

```

```

## Index

    - Install
    - API documentation

# Install

Clone repository and run command mvn install

# API documentation

## API reference contents

     GET  /game/{id}
     POST /game

## GET /game/{id}

Returns the json message

### Resource Information

| Question                 | Answer |
| ------------------------ | ------ |
| Response formats         | Json   |
| Requires authentication? | no     |

### Example Response

```json
{
  "id": 1,
  "speedway": {
    "id": 1,
    "distance": 2000,
    "howManylanes": 4
  },
  "drivers": [
    {
      "id": 1,
      "name": "driver1",
      "races": [],
      "car": {}
    },
    {
      "id": 2,
      "name": "driver2",
      "races": [],
      "car": {}
    },
    {
      "id": 3,
      "name": "driver3",
      "races": [],
      "car": {}
    },
    {
      "id": 4,
      "name": "driver4",
      "races": [],
      "car": {}
    }
  ],
  "status": "FINISH",
  "turns": [
    [500, 500, 200, 400, 600],
    [300, 500, 500, 200],
    [300, 300, 500, 600],
    [300, 300, 200, 300]
  ],
  "podium": ["driver1=2200", "driver3=1700", "driver2=1500"]
}
```

### Parameters

not have

# POST /game

Create a New Game

### Resource Information

| Question                 | Answer |
| ------------------------ | ------ |
| Response formats         | Json   |
| Requires authentication? | no     |

### Parameters

not have

### Example Request

```Json
{


    "speedway": {

        "distance": 2000,
        "howManylanes": 4
    },
    "drivers": [
        {

            "name": "driver1",
            "car" :{

            }
        },
        {

            "name": "driver2",
            "car" :{

            }
        },
        {

            "name": "driver3"
            ,
            "car" :{

            }
        },
        {

            "name": "driver4",
            "car" :{

            }

        }
    ]
}
```

### Example Response

```json
{
  "Message": "Juego Iniciado",
  "Id": "1"
}
```
