package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import security.UserAccount;
import security.UserAccountRepository;

@Service
@Transactional
public class UserAccountService {
	
	//Managed Repository
		@Autowired
		private UserAccountRepository	userAccountRepository;


		//Supporting Services

		//Constructor
		public UserAccountService() {
			super();
		}

		//Simple CRUD methods
		public UserAccount create() {
			return new UserAccount();
		}

		public UserAccount findOneByUsername(final String username) {
			Assert.notNull(username);
			return this.userAccountRepository.findByUsername(username);
		}

		public UserAccount findOne(final int id) {
			return this.userAccountRepository.findOne(id);
		}

		public Collection<UserAccount> findAll() {
			return this.userAccountRepository.findAll();
		}

		public UserAccount save(final UserAccount userAccount) {
			Assert.notNull(userAccount);
			return this.userAccountRepository.save(userAccount);
		}

		public Collection<UserAccount> saveAll(final Collection<UserAccount> userAccounts) {
			Assert.notNull(userAccounts);
			return this.userAccountRepository.save(userAccounts);
		}

}
