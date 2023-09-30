interface Server {
  id: number;
  ipAddress: string;
  name: string;
  memory: string;
  type: string;
  status: Status;
}

enum Status {
  SERVER_UP = 'SERVER_UP',
  SERVER_DOWN = 'SERVER_DOWN',
}
