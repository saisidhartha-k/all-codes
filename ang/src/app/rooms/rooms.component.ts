import { Component } from '@angular/core';
import { Room, RoomList } from './rooms';
import { RoomsService } from '../rooms.service';

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css'],
})
export class RoomsComponent {
  hideRooms = false;
  hotelName = 'chows';
  selectedRoom!: RoomList;
  rooms: Room = {
    availableRooms: 10,
    bookedRoome: 1,
  };

  constructor(private roomsService: RoomsService) {}

  roomList: RoomList[] = [];

  ngOnInit(): void {
    this.roomList = this.roomsService.getRooms();
  }

  toggle() {
    this.hideRooms = !this.hideRooms;
  }

  selectRoom(room: RoomList) {
    console.log(room);
    this.selectedRoom = room;
  }

  addRoom() {
    let newRoom: RoomList = {
      roomNumber: 3,
      roomType: 'deluxe',
      price: 20,
      roomId: 3,
      checkInTime: new Date(21 / 2 / 2003),
      checkOutTime: new Date(21 / 2 / 2003),
    };
    // this.roomList.push(newRoom);
    this.roomList = [...this.roomList, newRoom];
  }
}
