<!doctype html>
<html ng-app="todoApp">
<head>
	<script src="webjars/angularjs/1.5.0/angular.min.js"></script>
	<script src="webjars/angular-material/1.0.6/angular-material.min.js"></script>
	<script src="webjars/angular-animate/1.5.0/angular-animate.min.js"></script>
	<script src="webjars/angular-aria/1.5.0/angular-aria.min.js"></script>
	<script src="assets/js/index.js"></script>
</head>
<body>
	<h2>Todo</h2>
	<div ng-controller="TodoListController as todoList">
		<span>{{todoList.remaining()}} of {{todoList.todos.length}}
			remaining</span> [ <a href="" ng-click="todoList.archive()">archive</a> ]
		<ul class="unstyled">
			<li ng-repeat="todo in todoList.todos"><label class="checkbox">
					<input type="checkbox" ng-model="todo.done"> <span
					class="done-{{todo.done}}">{{todo.text}}</span>
			</label></li>
		</ul>
		<form ng-submit="todoList.addTodo()">
			<input type="text" ng-model="todoList.todoText" size="30"
				placeholder="add new todo here"> <input class="btn-primary"
				type="submit" value="add">
		</form>
	</div>
</body>
</html>