<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>		
		<div layout="row">
			  <div flex="20">
			  </div>
			  <div flex=60>
		  <h2>Cadastro de Conta Bancária</h2>
<!-- 		  <p>Tipo de Usuário</p>
    	   <md-radio-group ng-model="usuario.tipoUsuario">
		      <md-radio-button value="ROLE_USUARIO" aria-checked="true" class="md-checked">Usuário</md-radio-button>
		      <md-radio-button value="ROLE_ADMINISTRADOR">Administrador</md-radio-button>
           </md-radio-group> -->
		   </md-input-container>		  
          <md-input-container class="md-block" flex-gt-sm>
	      	<label>Agência</label>
	      		<input ng-model="contaBancaria.agencia">
	      </md-input-container>
          <md-input-container class="md-block" flex-gt-sm>
          	<label>Nr. Conta</label>
            	<input ng-model="contaBancaria.numero">
          </md-input-container>
          <div layout="row">
          <md-button class="md-raised" href="#/contaBancaria">Voltar</md-button>
          <div flex></div>
          <md-button class="md-raised md-primary" ng-click="adicionarContaBancaria(contaBancaria)">Salvar</md-button>
		  </div>
			  <div flex>
			  </div>
		</div>
        </div>