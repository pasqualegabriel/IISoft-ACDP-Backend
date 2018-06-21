

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'NormalUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'NormalUserRole'
grails.plugin.springsecurity.authority.className = 'Role'

grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
		[pattern: '/',               access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],


		[pattern: '/api/login',          		   access: ['permitAll']],
		[pattern: '/api/logout',         		   access: ['isFullyAuthenticated()']],

		[pattern: '/users',              		   access: ['permitAll']],
		//post   "/user"                             (controller:"user", action:"saveUser") tiene que ser autenticado
		[pattern: '/user',               		   access: ['permitAll']],
		[pattern: '/user/**',            		   access: ['permitAll']],
		[pattern: '/newUser',            		   access: ['permitAll']],

		[pattern: '/categories',                   access: ['isFullyAuthenticated()']],
		[pattern: '/publications',                 access: ['isFullyAuthenticated()']],
		[pattern: '/publication',            	   access: ['isFullyAuthenticated()']],
		[pattern: '/publication/subscriber/**',    access: ['isFullyAuthenticated()']],
		[pattern: '/publication/**',               access: ['isFullyAuthenticated()']],

		[pattern: '/comments/**',          		   access: ['isFullyAuthenticated()']],
		[pattern: '/commentary',            	   access: ['isFullyAuthenticated()']],

		[pattern: '/categories',            	   access: ['isFullyAuthenticated()']],
		[pattern: '/categories',            	   access: ['isFullyAuthenticated()']],
		[pattern: '/categories',            	   access: ['isFullyAuthenticated()']],



		[pattern: '/api/logout',           		   access: ['isFullyAuthenticated()']]
]


grails.plugin.springsecurity.filterChain.chainMap = [

		[pattern: '/users',               		filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],
		//post   "/user"                             (controller:"user", action:"saveUser") tiene que ser autenticado
		[pattern: '/user',                		filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],
		[pattern: '/user/**',            		filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],
		[pattern: '/newUser',            		filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],

		[pattern: '/categories',                filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
		[pattern: '/publications',              filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
		[pattern: '/publication',            	filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
		[pattern: '/publication/subscriber/**', filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
		[pattern: '/publication/**',            filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],

		[pattern: '/comments/**',        		filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
		[pattern: '/commentary',       			filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],

		[pattern: '/categories',        		filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
		[pattern: '/categories',         		filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
		[pattern: '/categories',         		filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],

		[pattern: '/**', filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
]


grails.plugin.springsecurity.rest.token.storage.jwt.secret =	'qrD6h8K6S9503Q06Y6Rfk21TErImPYqa'

grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'


