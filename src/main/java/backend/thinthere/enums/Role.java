package backend.thinthere.enums;

public enum Role {
  USER(UserAuthority.READ),
  ADMIN(UserAuthority.CREATE, UserAuthority.READ, UserAuthority.UPDATE, UserAuthority.DELETE);


  public final UserAuthority[] AUTHS;

  Role(UserAuthority... auths) {
    AUTHS = auths;
  }
}
