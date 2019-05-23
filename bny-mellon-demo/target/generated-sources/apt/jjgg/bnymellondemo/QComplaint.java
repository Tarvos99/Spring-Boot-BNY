package jjgg.bnymellondemo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComplaint is a Querydsl query type for Complaint
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QComplaint extends EntityPathBase<Complaint> {

    private static final long serialVersionUID = 671443542L;

    public static final QComplaint complaint = new QComplaint("complaint");

    public final StringPath company = createString("company");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> outcomeCount = createNumber("outcomeCount", Integer.class);

    public final StringPath product = createString("product");

    public final StringPath response = createString("response");

    public final NumberPath<Integer> totalCount = createNumber("totalCount", Integer.class);

    public QComplaint(String variable) {
        super(Complaint.class, forVariable(variable));
    }

    public QComplaint(Path<? extends Complaint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComplaint(PathMetadata metadata) {
        super(Complaint.class, metadata);
    }

}

