import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListCyclesComponent } from './list-cycles/list-cycles.component';
import { BorrowComponent } from './borrow/borrow.component';
// import { ReturnComponent } from './return/return.component';
import { RestockComponent } from './restock/restock.component';
import { AuthModule } from '@auth0/auth0-angular';


import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CycleService } from './cycle.service';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './cart/cart.component';
import { LogoutComponent } from './logout/logout.component';
import { RemoveFromCartComponent } from './remove-from-cart/remove-from-cart.component';
import { AuthButtonComponent } from './auth-button-component/auth-button-component.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
@NgModule({
  declarations: [
    AppComponent,
    ListCyclesComponent,
    BorrowComponent,
    // ReturnComponent,
    RestockComponent,
    LoginComponent,
    CartComponent,
    LogoutComponent,
    RemoveFromCartComponent,
     AuthButtonComponent,
     UserProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AuthModule.forRoot({
      domain: 'dev-5wyyxkptyofgkdq7.us.auth0.com',
      clientId: 'lTploEddCYml1s1fonAMrhrjxcKqljIO',
      authorizationParams: {
        redirect_uri: window.location.origin
      }
    }),
  ],
  providers: [CycleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
