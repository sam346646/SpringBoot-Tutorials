import { Component } from "@angular/core";

import { CoursesService } from "./course.service";

@Component({
    selector: 'courses',   //<courses> -> courses, <div class="courses"> -> .courses, id -> #courses
    //<h2>All Courses</h2>, <h2>{{ "Title: "+title }}</h2>
    template: `
                <h2>{{ "Title: "+getTitle() }}</h2>
                <ul>
                    <li *ngFor="let course of courses">{{ course }}</li>
                </ul>
             `
})
export class CoursesComponent {

    title = "All courses"
    courses;

    getTitle() {
        return this.title;
    }

    constructor(coursesService: CoursesService){
        // // this is tightly coupled since we have to do a same for everywhere we use service so let angular have dependency 
        // // by passsing coursesService: CoursesService
        // let coursesService=new CoursesService(); 

        this.courses= coursesService.getCourses();
    }

}