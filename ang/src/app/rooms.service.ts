import { Injectable } from '@angular/core';
import { RoomList } from './rooms/rooms';

@Injectable({
  providedIn: 'root'
})
export class RoomsService {

  constructor() { }

  roomList: RoomList[] = [
    {
      roomNumber: 1,
      roomType: 'deluxe',
      price: 100,
      checkInTime: new Date(10 / 11 / 2023),
      checkOutTime: new Date(11 / 12 / 2023),
      roomId: 1,
    },
    {
      roomNumber: 2,
      roomType: 'super deluxe',
      price: 1000,
      checkInTime: new Date(1 / 11 / 2023),
      checkOutTime: new Date(10 / 12 / 2023),
      roomId: 2,
    },
  ];

  getRooms()
  {
    return this.roomList;
  }
}
