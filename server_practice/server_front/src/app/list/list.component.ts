import { Component } from '@angular/core';
import { ServerService } from '../server.service';
import { Server } from '../serverInt';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent {
  constructor(private serverService: ServerService) {}

  servers: Server[] = [];

  ngOnInit(): void {
    this.getServerList();
  }

  getServerList(): void {
    this.serverService.getServers().subscribe((data) => {
      this.servers = data;
      console.log(this.servers);
    });
  }
}
