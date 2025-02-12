import { Routes } from '@angular/router';
import { CompanyComponent } from './company/company.component';
import { WorkerComponent } from './worker/worker.component';
import { CompanyListComponent } from './company-list/company-list.component';
import { WorkerListComponent } from './worker-list/worker-list.component';
import { MenuComponent } from './menu/menu.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
export const routes: Routes = [
    {path:"",component:MenuComponent},
    {path:"workerlist",component:WorkerListComponent},
    {path:"companylist",component:CompanyListComponent},
    {path:"worker/:id",component:WorkerComponent},
    {path:"company/:id",component:CompanyComponent},
    {path:"**",component:PageNotFoundComponent}
];
