package iisoft.acdp.backend.authentication

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class NormalUserRole implements Serializable {

	private static final long serialVersionUID = 1

	NormalUser normalUser
	Role role

	@Override
	boolean equals(other) {
		if (other instanceof NormalUserRole) {
			other.normalUserId == normalUser?.id && other.roleId == role?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (normalUser) {
            hashCode = HashCodeHelper.updateHash(hashCode, normalUser.id)
		}
		if (role) {
		    hashCode = HashCodeHelper.updateHash(hashCode, role.id)
		}
		hashCode
	}

	static NormalUserRole get(long normalUserId, long roleId) {
		criteriaFor(normalUserId, roleId).get()
	}

	static boolean exists(long normalUserId, long roleId) {
		criteriaFor(normalUserId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long normalUserId, long roleId) {
		NormalUserRole.where {
			normalUser == NormalUser.load(normalUserId) &&
			role == Role.load(roleId)
		}
	}

	static NormalUserRole create(NormalUser normalUser, Role role, boolean flush = false) {
		def instance = new NormalUserRole(normalUser: normalUser, role: role)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(NormalUser u, Role r) {
		if (u != null && r != null) {
			NormalUserRole.where { normalUser == u && role == r }.deleteAll()
		}
	}

	static int removeAll(NormalUser u) {
		u == null ? 0 : NormalUserRole.where { normalUser == u }.deleteAll() as int
	}

	static int removeAll(Role r) {
		r == null ? 0 : NormalUserRole.where { role == r }.deleteAll() as int
	}

	static constraints = {
	    normalUser nullable: false
		role nullable: false, validator: { Role r, NormalUserRole ur ->
			if (ur.normalUser?.id) {
				if (NormalUserRole.exists(ur.normalUser.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['normalUser', 'role']
		version false
	}
}
