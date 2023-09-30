import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { Room, RoomList } from '../rooms/rooms';

@Component({
  selector: 'app-rooms-list',
  templateUrl: './rooms-list.component.html',
  styleUrls: ['./rooms-list.component.css'],
})
export class RoomsListComponent {
  @Input() rooms: RoomList[] = [];
  // @Input() room: Room["availableRooms"] ;
  
  @Output() selectedRoom = new EventEmitter<RoomList>();
  selectRoom(room : RoomList)
  {
    // console.log(room);
    this.selectedRoom.emit(room);
  }
}
