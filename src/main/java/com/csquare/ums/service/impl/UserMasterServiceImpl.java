//package com.csquare.ums.service.impl;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Objects;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.csquare.ums.dao.RoleMasterRepository;
//import com.csquare.ums.dao.UserMasterRepository;
//import com.csquare.ums.dto.AuthenticationRequest;
//import com.csquare.ums.dto.UserMasterDTO;
//import com.csquare.ums.model.UserInfo;
//import com.csquare.ums.model.UserMaster;
//import com.csquare.ums.service.IUserMasterService;
//import com.csquare.ums.util.SecurityUtil;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Service
//	@Transactional
//	public class UserMasterServiceImpl implements IUserMasterService, UserDetailsService{
//		
//		
//		@Autowired
//		private UserMasterRepository userMasterRepository;
//		
//		@Autowired
//		private RoleMasterRepository roleMasterRepository;
//		
////		@Autowired
////		private UserRoleRepository userRoleRepository;
////		
////		@Autowired
////		private HierarchyMasterRepository hierarchyMasterRepository;
////		
////		@Autowired
////		private HierarchyRelationRepository hierarchyRelationRepository;
////		
//		@Autowired
//		private ObjectMapper objectMapper;
//
//		@Override
//		public UserMaster authUser(AuthenticationRequest authRequest) {
//			return userMasterRepository.findByUserNameAndPassword(authRequest.getUserName(), authRequest.getPassword());
//			
//		}
//
//		@Override
//		@Transactional
//		public UserMaster addUpdateUser(UserMasterDTO userMasterDTO) throws DiamondException {
//			UserMaster userMaster = null;
//			if(Objects.nonNull(userMasterDTO)) {
//				if(Objects.nonNull(userMasterDTO.getUserId()) && userMasterDTO.getUserId() >0) {
//					userMaster = userMasterRepository.findOne(userMasterDTO.getUserId());
//					if(Objects.isNull(userMaster)) {
//					}
//				}else {
//					userMaster = new UserMaster();
//				}
//			
//				userMaster.setFirstName(userMasterDTO.getFirstName());
//				userMaster.setLastName(userMasterDTO.getLastName());
//				userMaster.setEmail(userMasterDTO.getEmail());
//				userMaster.setMobileNumber(userMasterDTO.getMobileNumber());
//				
//				userMaster.setPassword(userMasterDTO.getPassword());
//				userMaster.setEnabled(true);
//				userMaster.setUserName(userMasterDTO.getUserName());
//				HierarchyRelation hierarchyRelation = SecurityUtil.getUserInfo().getUser().getCompany();
////				if(Objects.nonNull(userMasterDTO.getCompanyId())){
////					HierarchyRelation hierarchyRelation = hierarchyRelationRepository.findOne(userMasterDTO.getCompanyId());
////					userMaster.setCompany(hierarchyRelation);
////				}else {
////					throw new DiamondException("Please select company");
////				}
//				userMaster.setCompany(hierarchyRelation);
//				
//				UserMaster userMasterEntity = userMasterRepository.save(userMaster); 
//				
//				//handling edit scenarios. - Delete all previous role and add new assigned roles
//				List<UserRole> userRoles = userRoleRepository.findByUserMaster(userMaster);
//				if(Objects.nonNull(userRoles) && !userRoles.isEmpty()) {
//					userRoleRepository.deleteInBatch(userRoles);
//				}
//				
//				Set<UserRole> userRoleList = new HashSet<UserRole>();
//				if(Objects.nonNull(userMasterDTO.getUserRoles())) {
//					for(Long roleId: userMasterDTO.getRoles()) {
//						if(Objects.nonNull(roleId)) {
//							 RoleMaster roleMaster = roleMasterRepository.findOne(roleId);
//		                      if(Objects.nonNull(roleMaster) && Objects.nonNull(userMasterEntity)) {
//		                    	  UserRole userRole = new UserRole();
//		                          userRole.setRoleMaster(roleMaster);
//		                          userRole.setUserMaster(userMasterEntity);
//		                          userRoleList.add(userRole);
//		                      }
//		                      userRoleRepository.save(userRoleList);	
//						}
//	                      
//	                     
//					}
//				}
//				 
//			}
//			
//			return userMaster;
//		}
//
//		@Override
//		public List<UserMaster> getAllUsers() throws DiamondException {
//			
//			return userMasterRepository.findAll();
//		}
//
//		@Override
//		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//			UserMaster userMaster= userMasterRepository.findUserMasterByUserName(userName);
//			List<GrantedAuthority> authorities = new ArrayList<>();
//			
//			for (UserRole userRole : userMaster.getUserRoles()) {
//				authorities.add(new SimpleGrantedAuthority(userRole.getRoleMaster().getRoleName()));
//			}
//			
//			return new UserInfo(userMaster.getUserName(), userMaster.getPassword(),userMaster, authorities);
//			
//		}
//
//		@Override
//		public UserMaster getUserById(Long userId) {
//			return userMasterRepository.findOne(userId);
//			
//		}
//
//		@Override
//		public UserMaster getUserByUsername(String username) {
//			
//			return userMasterRepository.findUserMasterByUserName(username);
//		}
//
//		@Override
//		public UserMaster acitvateDeactivateUser(Long userId) {
//			
//			UserMaster userMaster= userMasterRepository.findOne(userId);
//			if(userMaster.isEnabled()) {
//				userMaster.setEnabled(false);
//			}else {
//				userMaster.setEnabled(true);
//			}
//			userMasterRepository.save(userMaster);
//			return userMaster;
//		}
//}
