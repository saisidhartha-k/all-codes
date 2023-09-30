export interface Room {
  availableRooms: number;
  bookedRoome: number;
}

export interface RoomList {
  roomNumber: number;
  roomType: String;
  price: number;
  roomId: number;
  checkInTime: Date;
  checkOutTime: Date;
}
