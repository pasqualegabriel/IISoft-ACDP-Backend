

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'iisoft.acdp.backend.authentication.NormalUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'iisoft.acdp.backend.authentication.NormalUserRole'
grails.plugin.springsecurity.authority.className = 'iisoft.acdp.backend.authentication.Role'

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
		[pattern: '/user',               		   access: ['isFullyAuthenticated()']],


		[pattern: '/user/**',            		   access: ['permitAll']],

		[pattern: '/newUser',            		   access: ['permitAll']],
		[pattern: '/user/mail/**',            	   access: ['permitAll']],

		[pattern: '/categories',                   access: ['isFullyAuthenticated()']],
		[pattern: '/publications',                 access: ['isFullyAuthenticated()']],
		[pattern: '/publication',            	   access: ['isFullyAuthenticated()']],
		[pattern: '/publication/subscriber/**',    access: ['isFullyAuthenticated()']],
		[pattern: '/publication/**',               access: ['isFullyAuthenticated()']],
		[pattern: '/publication/title/**',         access: ['isFullyAuthenticated()']],

		[pattern: '/comments/**',          		   access: ['isFullyAuthenticated()']],
		[pattern: '/commentary',            	   access: ['isFullyAuthenticated()']],

		[pattern: '/categories',            	   access: ['isFullyAuthenticated()']],
		[pattern: '/categories',            	   access: ['isFullyAuthenticated()']],
		[pattern: '/categories',            	   access: ['isFullyAuthenticated()']],

		[pattern: '/**',             access: ['permitAll']]
    ]

    grails.plugin.springsecurity.filterChain.chainMap = [

			[pattern: '/users',               		filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],
			[pattern: '/user',                		filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter'],
			[pattern: '/user/**',            		filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],



			[pattern: '/newUser',            		filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],
			[pattern: '/user/mail/**',              filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],

			[pattern: '/categories',                filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
			[pattern: '/publications',              filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
			[pattern: '/publication',            	filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
			[pattern: '/publication/subscriber/**', filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
			[pattern: '/publication/**',            filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
			[pattern: '/publication/title/**',      filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],

			[pattern: '/comments/**',        		filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
			[pattern: '/commentary',       			filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],

			[pattern: '/categories',        		filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
			[pattern: '/categories',         		filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],
			[pattern: '/categories',         		filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter' ],

			[pattern: '/**', filters:'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
]


grails.plugin.springsecurity.rest.token.storage.jwt.secret =	'qrD6h8K6S9503Q06Y6Rfk21TErImPYqa'

grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'


